@file:JvmName("FormatterStatistics")

package de.rki.coronawarnapp.util.formatter

import android.content.Context
import de.rki.coronawarnapp.R
import de.rki.coronawarnapp.contactdiary.util.getLocale
import de.rki.coronawarnapp.contactdiary.util.toFormattedDay
import de.rki.coronawarnapp.server.protocols.internal.stats.KeyFigureCardOuterClass
import org.joda.time.Instant
import org.joda.time.LocalDate

fun getPrimaryData(items: List<KeyFigureCardOuterClass.KeyFigure>?): String {
    return items?.firstOrNull { it.rank == KeyFigureCardOuterClass.KeyFigure.Rank.PRIMARY }?.value.toString()
}

fun getSecondaryData(items: List<KeyFigureCardOuterClass.KeyFigure>?): String {
    return items?.firstOrNull { it.rank == KeyFigureCardOuterClass.KeyFigure.Rank.SECONDARY }?.value.toString()
}

fun getTertiaryData(items: List<KeyFigureCardOuterClass.KeyFigure>?): String {
    return items?.firstOrNull { it.rank == KeyFigureCardOuterClass.KeyFigure.Rank.TERTIARY }?.value.toString()
}

fun getPrimaryLabel(instant: Instant?, context: Context): String {
    val today = LocalDate()
    val yesterday = today.minusDays(1)
    return when (val localDate = LocalDate(instant)) {
        today -> {
            context.getString(R.string.statistics_primary_value_today)
        }
        yesterday -> {
            context.getString(R.string.statistics_primary_value_yesterday)
        }
        else -> {
            localDate.toFormattedDay(context.getLocale())
        }
    }
}


