package org.ositran.utils;

/**
 * <P>Includes calculation methods used for forecasting a date.
 *
 * <P>Basic question it can answer is, what is X business days from now?
 * This is based on parameters such as what days of the week are
 * excluded (i.e. weekends) and specific dates (holidays).
 *
 * @author Jonathan Chen (jonc101@hotmail.com)
 */
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;

public class Calculator {

   public static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("mm/dd/yyyy");
    private static Logger log=Logger.getLogger(Calculator.class);

   /**
    * Use to find out what date is a certain number of days after a base date,
    * not counting certain days.
    *
    * @param daysAway
    *      Number of non-excluded days from the baseDate
    *      that the result date will be
    * @param baseDate
    *      Date to start counting daysAway from.
    *      If specify "null" defaults to today
    * @param excludedDaysOfWeek
    *      Array of constants from java.util.Calendar object
    *      e.g. Calendar.SUNDAY, which are excluded from
    *      counting towards daysAway for the result
    * @return
    *      The earliest date which is daysAway days after the
    *      baseDate. In counting towards this result date,
    *      any excludedDaysOfWeek are excluded from counting
    *      towards the daysAway
    * @see DateBean#getEarliestNonExcludedDate(int, java.util.Date, int[], Set)
    */
   public static Date getEarliestNonExcludedDate(int daysAway, int horas, Date baseDate, int[] excludedDaysOfWeek) {
      return getEarliestNonExcludedDate(daysAway, horas, baseDate, excludedDaysOfWeek, (Set) null);
   }

   /**
    * Use to find out what date is a certain number of days after a base date,
    * not counting certain days.
    *
    * @param daysAway
    *      Number of non-excluded days from the baseDate
    *      that the result date will be
    * @param baseDate
    *      Date to start counting daysAway from.
    *      If specify "null" defaults to today
    * @param excludedDaysOfWeek
    *      Array of constants from java.util.Calendar object
    *      e.g. Calendar.SUNDAY, which are excluded from
    *      counting towards daysAway for the result
    * @param excludedDateList
    *      Array of date strings
    *      (formatted as <CODE>SimpleDateFormat.getDateInstance().format(</CODE>))
    *      which represent specific dates which should be
    *      excluded from the counting of days, such as holidays
    * @return
    *      The earliest date which is daysAway days after the
    *      baseDate. In counting towards this result date,
    *      any excludedDaysOfWeek are excluded from counting
    *      towards the daysAway
    * @see DateBean#getEarliestNonExcludedDate(int, java.util.Date, int[], Set)
    */
   public static Date getEarliestNonExcludedDate(int daysAway, int horas, Date baseDate, int[] excludedDaysOfWeek, String[] excludedDateList) {
      // Build Set for excluded dates for rapid lookup
      Set excludedDates = new HashSet();
      if (excludedDateList != null) {
         for (int i = 0; i < excludedDateList.length; i++) {
            try {
               excludedDates.add(SimpleDateFormat.getDateInstance().parse(excludedDateList[i]));
            } catch (ParseException err) { /* do nothing, just skip this one */ }
         }
      }
      return getEarliestNonExcludedDate(daysAway, horas, baseDate, excludedDaysOfWeek, excludedDates);
   }

   /**
    * Use to find out what date is a certain number of days after a base date,
    * not counting certain days.
    *
    * @param daysAway
    *      Number of non-excluded days from the baseDate
    *      that the result date will be
    * @param baseDate
    *      Date to start counting daysAway from.
    *      If specify "null" defaults to today
    * @param excludedDaysOfWeek
    *      Array of constants from java.util.Calendar object
    *      e.g. Calendar.SUNDAY, which are excluded from
    *      counting towards daysAway for the result
    * @param excludedDateList
    *      Array of date objects
    *      which represent specific dates which should be
    *      excluded from the counting of days, such as holidays
    * @return
    *      The earliest date which is daysAway days after the
    *      baseDate. In counting towards this result date,
    *      any excludedDaysOfWeek are excluded from counting
    *      towards the daysAway
    * @see DateBean#getEarliestNonExcludedDate(int, java.util.Date, int[], Set)
    */
   public static Date getEarliestNonExcludedDate(int daysAway, int horas, Date baseDate, int[] excludedDaysOfWeek, Date[] excludedDateList) {
      // Build Set for excluded dates for rapid lookup
      Set excludedDates = new HashSet();
      if (excludedDateList != null) {
         for (int i = 0; i < excludedDateList.length; i++) {
            excludedDates.add(excludedDateList[i]);
         }
      }
      return getEarliestNonExcludedDate(daysAway, horas, baseDate, excludedDaysOfWeek, excludedDates);
   }

   /**
    * <P>Use to find out what date is a certain number of days after a base date,
    * not counting certain days.
    *
    * <P>
    * <b>Primary example:</B>
    *    Give me the date which is at least 3 business days from today.
    * <P>
    * <b>Usage for example:</B>
    * <UL>
    *    <LI><CODE>daysAway</CODE>             = 3
    *    <LI><CODE>baseDate</CODE>             = today (i.e. <CODE>new Date()</CODE> )
    *    <LI><CODE>excludedDaysOfWeek</CODE>   = array with values for Sat and Sun
    *                                            (i.e. <CODE>{ Calendar.SATURDAY, Calendar.SUNDAY }</CODE> )
    *    <LI><CODE>excludedDates</CODE>        = <CODE>Set</CODE> with elements whose keys are
    *                                            <CODE>java.util.Date</CODE> objects equal to various
    *                                            business holidays not to be counted towards progress
    * </UL>
    *
    * @param daysAway
    *      Number of non-excluded days from the baseDate
    *      that the result date will be
    * @param baseDate
    *      Date to start counting daysAway from.
    *      If specify "null," defaults to today
    * @param excludedDaysOfWeek
    *      Array of constants from java.util.Calendar object
    *      e.g. Calendar.SUNDAY, which are excluded from
    *      counting towards daysAway for the result
    * @param excludedDates
    *      Set of java.util.Date objects, which represent
    *      specific dates (12:00am midnight) which should
    *      be excluded from counting towards the daysAway
    * @return
    *      The earliest date which is daysAway days after the
    *      baseDate. In counting towards this result date,
    *      any excludedDaysOfWeek or specifically
    *      excludedDates are excluded from counting
    *      towards the daysAway
    */
   public static Date getEarliestNonExcludedDate(int daysAway, int horas, Date baseDate, int[] excludedDaysOfWeek, Set<Date> excludedDates) {
      int i;

      // Can only handle non-negative value for daysAway
      if (daysAway < 0 || horas < 0) {
         return null;
      }

      // Fill in default values
      if (baseDate == null) {
         baseDate = new Date(); // Default to today
      }
      Calendar baseCopy = Calendar.getInstance();
      Calendar baseCal = Calendar.getInstance();
      baseCopy.setTime(baseDate);
      // Zero out hour, minute, second, millisecond values, so can do day comparisons
      baseCal.clear();
      //baseCal.set(baseCopy.get(Calendar.YEAR), baseCopy.get(Calendar.MONTH), baseCopy.get(Calendar.DATE), baseCopy.get(Calendar.HOUR_OF_DAY), baseCopy.get(Calendar.MINUTE), baseCopy.get(Calendar.SECOND));
      baseCal.set(baseCopy.get(Calendar.YEAR), baseCopy.get(Calendar.MONTH), baseCopy.get(Calendar.DATE));

      if (excludedDaysOfWeek == null) {
         excludedDaysOfWeek = new int[0];
      }
      if (excludedDates == null) {
         excludedDates = new HashSet<Date>();
      }

      // Build Set for excluded days for rapid lookup
      Set excludedDays = new HashSet();
      for (i = 0; i < excludedDaysOfWeek.length; i++) {
         excludedDays.add(Integer.valueOf(excludedDaysOfWeek[i]));
      }

      // ============================================================================ //

      // Step 1 - If starting base date on an excluded day, move forward until not
      while (isExcludedDate(baseCal, excludedDays, excludedDates)) {
         baseCal.add(Calendar.DATE, 1);
      }



      Calendar resultCal = Calendar.getInstance();
      resultCal.setTime(baseCal.getTime());

      log.debug("Despues del paso 1 [" + resultCal.getTime() + "]");

      // Step 2 - If days away is greater than a weeks worth of time,
      //          use module arithmetic to save iterations
      //          so the next steps will run in O(1), maximum of 7 iterations (days per week)
      int daysPerWeek = resultCal.getMaximum(Calendar.DAY_OF_WEEK);
      int daysPerWeekNotExcluded = daysPerWeek - excludedDays.size();

      int diasadicionales = horas / 8;
      int nuevashoras = horas % 8;

      daysAway += diasadicionales;

      int wholeWeeksAway = daysAway / daysPerWeekNotExcluded;
      int remainingDaysAway = daysAway % daysPerWeekNotExcluded;

      log.debug("daysPerWeek [" + daysPerWeek + "]");
      log.debug("daysPerWeekNotExcluded [" + daysPerWeekNotExcluded + "]");
      log.debug("wholeWeeksAway [" + wholeWeeksAway + "]");
      log.debug("remainingDaysAway [" + remainingDaysAway + "]");

      resultCal.add(Calendar.DATE, wholeWeeksAway * daysPerWeek);

      log.debug("Despues del paso 2 [" + resultCal.getTime() + "]");

      // Step 3 - Have added the whole weeks, and since know we started on
      //          a non-excluded day of the week, currently on a non-excluded day of
      //          the week as well. See if there were any excluded dates (holidays)
      //          inside the time frame we just passed (that were on non-excluded days),
      //          then add a day for each one, skipping excluded days/dates
      int nExcludedDates = 0;

      for (Date nextExclDate : excludedDates) {
         Calendar nextExclCal = Calendar.getInstance();
         nextExclCal.setTime(nextExclDate);

         if ((!excludedDays.contains(Integer.valueOf(nextExclCal.get(Calendar.DAY_OF_WEEK)))) &&
               (baseCal.before(nextExclCal)) && (!resultCal.before(nextExclCal))) {
            // The excluded date ( holiday ) is in the time frame we passed,
            //  and it wasn't on one of the already skipped excluded days of the week,
            //  so need to count it as one to exclude by adding an extra day to the result date
            nExcludedDates++;
         }
      }

      // Step 4 - Now just iterate for the remainingDaysAway + nExcludedDates,
      //          checking for excluded days and dates as go to get through the rest
      remainingDaysAway = remainingDaysAway + nExcludedDates;
      for (i = 0; i < remainingDaysAway; i++) {
         do {
            resultCal.add(Calendar.DATE, 1);
         } while (isExcludedDate(resultCal, excludedDays, excludedDates));
      }

      log.debug("Despues del paso 4 [" + resultCal.getTime() + "]");

      if (isExcludedDate(baseCopy, excludedDays, excludedDates)) {
         resultCal.set(resultCal.get(Calendar.YEAR), resultCal.get(Calendar.MONTH), resultCal.get(Calendar.DATE), baseCopy.getMinimum(Calendar.HOUR_OF_DAY), baseCopy.get(Calendar.MINUTE), baseCopy.get(Calendar.SECOND));
      } else {
         resultCal.set(resultCal.get(Calendar.YEAR), resultCal.get(Calendar.MONTH), resultCal.get(Calendar.DATE), baseCopy.get(Calendar.HOUR_OF_DAY), baseCopy.get(Calendar.MINUTE), baseCopy.get(Calendar.SECOND));
      }

      log.debug("Nueva hora [" + resultCal.getTime() + "]");

      for (int j = 0; j < nuevashoras; j++) {
         while (!(resultCal.get(Calendar.HOUR_OF_DAY) >= 9 && resultCal.get(Calendar.HOUR_OF_DAY) < 18)) {
            resultCal.add(Calendar.HOUR_OF_DAY, 1);

            //log.debug("while 1 [" + resultCal.getTime() + "]");

            while (isExcludedDate(resultCal, excludedDays, excludedDates)) {
               resultCal.add(Calendar.DATE, 1);
            }

            //log.debug("while 2 [" + resultCal.getTime() + "]");
         }

         resultCal.add(Calendar.HOUR_OF_DAY, 1);

         //log.debug("for [" + resultCal.getTime() + "] j [" + j + "]");
      }

      return resultCal.getTime();
   }

   /**
    * Tells you if the checkCal day/date is in one of the exclusion lists
    *
    * @param checkCal
    *      Calendar objects representing the date to check
    * @param excludedDays
    *      Set with Integer keys representing days of the
    *      week which count as excluded. Integer keys
    *      are constants from Calendar class, e.g. Calendar.SUNDAY
    * @param excludedDates
    *      Set with elements with java.util.Date objects
    *      as keys which represent specific dates which
    *      should be excluded. Dates should all be set
    *      on 12am midnight for correct comparison.
    * @return
    *      True if the checkCal date is one of the days or dates
    *      that are to be excluded, as specified by the
    *      excludedDays and excludedDates parameters
    */
   public static boolean isExcludedDate(Calendar checkCal, Set<Integer> excludedDays, Set<Date> excludedDates) {
      // Create a testCal copy of checkCal, to zero out time values to
      //  12:00am midnight, so comparisons don't have any issues
      Calendar testCal = Calendar.getInstance();
      testCal.clear();
      testCal.set(checkCal.get(Calendar.YEAR), checkCal.get(Calendar.MONTH), checkCal.get(Calendar.DAY_OF_MONTH));
      return ((excludedDays != null && excludedDays.contains(Integer.valueOf(checkCal.get(Calendar.DAY_OF_WEEK)))) ||
            (excludedDates != null && excludedDates.contains(testCal.getTime())));
   }
}
