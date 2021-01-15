@file:JvmName("FormatterStatistics")

package de.rki.coronawarnapp.util.formatter

import de.rki.coronawarnapp.server.protocols.internal.stats.KeyFigureCardOuterClass
import org.joda.time.Instant

fun getPrimaryData(items: List<KeyFigureCardOuterClass.KeyFigure>?): String {
    return items?.firstOrNull { it.rank == KeyFigureCardOuterClass.KeyFigure.Rank.PRIMARY }?.value.toString()
}

fun getSecondaryData(items: List<KeyFigureCardOuterClass.KeyFigure>?): String {
    return items?.firstOrNull { it.rank == KeyFigureCardOuterClass.KeyFigure.Rank.SECONDARY }?.value.toString()
}

fun getTertiaryData(items: List<KeyFigureCardOuterClass.KeyFigure>?): String {
    return items?.firstOrNull { it.rank == KeyFigureCardOuterClass.KeyFigure.Rank.TERTIARY }?.value.toString()
}

fun getPrimaryLabel(instant: Instant?): String {
    return "Gestern" //TODO: implement me
}


