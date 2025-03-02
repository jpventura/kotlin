/*
 * Copyright 2010-2021 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.checkers.expression

import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.fir.analysis.diagnostics.FirErrors
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.declarations.fullyExpandedClass
import org.jetbrains.kotlin.fir.expressions.FirQualifiedAccess
import org.jetbrains.kotlin.fir.expressions.FirResolvedQualifier
import org.jetbrains.kotlin.fir.symbols.FirBasedSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirRegularClassSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirTypeAliasSymbol
import org.jetbrains.kotlin.fir.types.isUnit

object FirStandaloneQualifierChecker : FirResolvedQualifierChecker() {
    override fun check(expression: FirResolvedQualifier, context: CheckerContext, reporter: DiagnosticReporter) {
        val lastQualifiedAccess = context.qualifiedAccessOrAnnotationCalls.lastOrNull() as? FirQualifiedAccess
        // Note: qualifier isn't standalone when it's in receiver (SomeClass.foo) or getClass (SomeClass::class) position
        if (lastQualifiedAccess?.explicitReceiver === expression || lastQualifiedAccess?.dispatchReceiver === expression) return
        val lastGetClass = context.getClassCalls.lastOrNull()
        if (lastGetClass?.argument === expression) return
        // Note: if it's real Unit, it will be filtered by ClassKind.OBJECT check below
        if (!expression.typeRef.isUnit) return
        expression.symbol.reportErrorOn(expression.source, context, reporter)
    }

    private fun FirBasedSymbol<*>?.reportErrorOn(source: KtSourceElement?, context: CheckerContext, reporter: DiagnosticReporter) {
        when (this) {
            is FirRegularClassSymbol -> {
                if (classKind == ClassKind.OBJECT) return
                reporter.reportOn(source, FirErrors.NO_COMPANION_OBJECT, this, context)
            }
            is FirTypeAliasSymbol -> {
                fullyExpandedClass(context.session)?.reportErrorOn(source, context, reporter)
            }
            null -> {
                reporter.reportOn(source, FirErrors.EXPRESSION_EXPECTED_PACKAGE_FOUND, context)
            }
            else -> {}
        }
    }
}
