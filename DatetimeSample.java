import java.util.Date;
import java.util.Calendar;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.DateTimeFormatter;
import java.time.LocalTime;


public class DatetimeSample {
    /*对一些基础方法的改造
        --dateFormat
        public static String dateFormat(Date date, String dateFormat) {
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            return formatter.format(date);
            }
                */
    //使用java.time改造后
         /* public static String dateFormat(LocalDateTime date, String dateFormat){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            return date.format(formatter);
        } */


        /*
        原来的方法
        public static Date addSecond(Date date, int second) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(13, second);
                return calendar.getTime();
            }
            
            public static Date addMinute(Date date, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(12, minute);
                return calendar.getTime();
            }
            
            public static Date addHour(Date date, int hour) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(10, hour);
                return calendar.getTime();
            }
            
            public static Date addDay(Date date, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(5, day);
                return calendar.getTime();
            }
            
            public static Date addMonth(Date date, int month) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(2, month);
                return calendar.getTime();
            }
            
            public static Date addYear(Date date, int year) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(1, year);
                return calendar.getTime();
            } */

            /* 改造后的方法
             * 
             */
            public static LocalDateTime addSecond(LocalDateTime date, int second) {
                return date.plusSeconds(second);
            }
            
            public static LocalDateTime addMinute(LocalDateTime date, int minute) {
                return date.plusMinutes(minute);
            }
            
            public static LocalDateTime addHour(LocalDateTime date, int hour) {
                return date.plusHours(hour);
            }
            
            public static LocalDateTime addDay(LocalDateTime date, int day) {
                return date.plusDays(day);
            }
            
            public static LocalDateTime addMonth(LocalDateTime date, int month) {
                return date.plusMonths(month);
            }
            
            public static LocalDateTime addYear(LocalDateTime date, int year) {
                return date.plusYears(year);
            }

        /* public static final String[] WEEK_DAY_OF_CHINESE = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
           public static String dateToWeek(Date date) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                return WEEK_DAY_OF_CHINESE[cal.get(7) - 1];
           } 
           
        改造后
           */

           public static final String[] WEEK_DAY_OF_CHINESE = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

           public static String dateToWeek(LocalDate date) {
           DayOfWeek dayOfWeek = date.getDayOfWeek();
           return WEEK_DAY_OF_CHINESE[dayOfWeek.getValue() % 7];
           }

           /* public static Date getStartTimeOfDay(Date date) {
    if (date == null) {
        return null;    } else {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }
}

public static Date getEndTimeOfDay(Date date) {
    if (date == null) {
        return null;
    } else {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }
} */

//改造以后
public static LocalDateTime getStartTimeOfDay(LocalDateTime date) {
        if (date == null) {
            return null;
        } else {
            // 获取一天的开始时间，即00:00
            return date.toLocalDate().atStartOfDay();
        }
    }
    
    public static LocalDateTime getEndTimeOfDay(LocalDateTime date) {
        if (date == null) {
            return null;
        } else {
            // 获取一天的结束时间，即23:59:59.999999999
            return date.toLocalDate().atTime(LocalTime.MAX);
        }
    }

    /* public static Boolean betweenStartAndEnd(Date nowTime, Date beginTime, Date endTime) {
    Calendar date = Calendar.getInstance();
    date.setTime(nowTime);
    Calendar begin = Calendar.getInstance();
    begin.setTime(beginTime);
    Calendar end = Calendar.getInstance();
    end.setTime(endTime);
    return date.after(begin) && date.before(end);
} */
        //改造后
        public static Boolean betweenStartAndEnd(Instant nowTime, Instant beginTime, Instant endTime) {
                return nowTime.isAfter(beginTime) && nowTime.isBefore(endTime);
            }


    public static void main(String[] args){
        Date today = new Date();
        //完整日期时间
        System.out.printf("完整日期时间tc——%tc",today);
        System.out.println();
        //ISO 8601日期
        System.out.printf("ISO 8601日期tF——%tF",today);
        System.out.println();
        //美国格式的日期（月/日/年）
        System.out.printf("美国日期格式tD——%tD",today);
        System.out.println();
        //24小时时间
        System.out.printf("24小时时间tT——%tT",today);
        System.out.println();
        //12小时时间
        System.out.printf("12小时时间tr——%tr",today);
        System.out.println();
        //24小时时间没有秒
        System.out.printf("24小时时间没有秒tR——%tR",today);
        System.out.println();
        //4位数字的年
        System.out.printf("4位数字的年tY——%tY",today);
        System.out.println();
        //年的后2位数字
        System.out.printf("年的后2位数字ty——%ty",today);
        System.out.println();
        //年的前2位数字
        System.out.printf("年的前2位数字tC——%tC",today);
        System.out.println();
        //月的完整拼写
        System.out.printf("月的完整拼写tB——%tB",today);
        System.out.println();
        //月的缩写
        System.out.printf("月的缩写tb——%tb",today);
        System.out.println();
        System.out.printf("月的缩写th——%th",today);
        System.out.println();
        //两位数字的月前面补0
        System.out.printf("两位数字的月tm前面补0——%tm",today);
        System.out.println();
        //两位数字的日前面补0
        System.out.printf("两位数字的日td前面补0——%td",today);
        System.out.println();
        //两位数字的日前面不补0
        System.out.printf("两位数字的日te前面不补0——%te",today);
        System.out.println();
        //星期几的完整拼写
        System.out.printf("星期几的完整拼写tA——%tA",today);
        System.out.println();
        //星期几的缩写
        System.out.printf("星期几的缩写ta——%ta",today);
        System.out.println();
        //用三位数表示现在的日是一年中的多少天，前面补0，取值在[001,366]
        System.out.printf("用三位数表示现在的日是一年中的多少天tj，前面补0，取值在[001,366]——%tj",today);
        System.out.println();
        //两位数的小时，前面补0，取值在[0,23]
        System.out.printf("两位数的小时tH，前面补0，取值在[0,23]——%tH",today);
        System.out.println();
        //两位数的小时，前面不补0，取值在[0,23]
        System.out.printf("两位数的小时tk，前面不补0，取值在[0,23]——%tk",today);
        System.out.println();
        //两位数的小时，前面补0，取值在[0,12]
        System.out.printf("两位数的小时tI，前面补0，取值在[0,12]——%tI",today);
        System.out.println();
        //两位数的小时，前面不补0，取值在[0,12]
        System.out.printf("两位数的小时tl，前面不补0，取值在[0,12]——%tl",today);
        System.out.println();
        //两位数字的分钟，前面补0
        System.out.printf("两位数的分钟tM，前面补0——%tM",today);
        System.out.println();
        //两位数字的秒钟，前面补0
        System.out.printf("两位数的秒钟tS，前面补0——%tS",today);
        System.out.println();
        //三位数字的毫秒，前面补0
        System.out.printf("三位数的毫秒tL，前面补0——%tL",today);
        System.out.println();
        //九位数的毫微秒，前面补0
        System.out.printf("九位数的毫微秒tN，后面补0——%tN",today);
        System.out.println();
        //上午或下午的标志
        System.out.printf("上午或下午的标志tp——%tp",today);
        System.out.println();
        //从GMT起，RFC 822数字位移
        System.out.printf("从GMT起，RFC 822数字位移tz，+0800表示中国标准时间比GMT快8小时——%tz",today);
        System.out.println();
        //时区
        System.out.printf("时区tZ——%tZ",today);
        System.out.println();
        //从格林尼治时间1970-01-01 00:00:00起的秒数
        System.out.printf("从格林尼治时间1970-01-01 00:00:00起的秒数ts——%ts",today);
        System.out.println();
        //从格林尼治时间1970-01-01 00:00:00起的毫秒数
        System.out.printf("从格林尼治时间1970-01-01 00:00:00起的毫秒数tQ——%tQ",today);
        System.out.println();
        //利用参数索引打印日期格式，索引必须跟在%后面，并以$终止
        System.out.printf("%1$s %2$tB %2$te,%2$tY","Due date:",today);
        System.out.println();
        //利用<标志，将前面格式中使用过的参数再次使用，与上一句的输出效果相同
        System.out.printf("%s %tB %<te,%<tY","Due date:",today);
        System.out.println();

        //www.cnblogs.com/wlovet/p/18058514

        /*java.util.Date（Date从现在开始）是一个糟糕的类型，这解释了为什么它的大部分内容在 Java 1.1 中被弃用（但不幸的是仍在使用）。

        设计缺陷包括：
        它的名称具有误导性：它并不代表一个日期，而是代表时间的一个瞬间。所以它应该被称为Instant——正如它的java.time等价物一样。
        它是非最终的：这鼓励了对继承的不良使用，例如java.sql.Date（这意味着代表一个日期，并且由于具有相同的短名称而也令人困惑）
        它是可变的：日期/时间类型是自然值，可以通过不可变类型有效地建模。可变的事实Date（例如通过setTime方法）意味着勤奋的开发人员最终会在各处创建防御性副本。
        它在许多地方（包括）隐式使用系统本地时区，toString()这让许多开发人员感到困惑。有关此内容的更多信息，请参阅“什么是即时”部分
        它的月份编号是从 0 开始的，是从 C 语言复制的。这导致了很多很多相差一的错误。
        它的年份编号是基于 1900 年的，也是从 C 语言复制的。当然，当 Java 出现时，我们已经意识到这不利于可读性？
        它的方法命名不明确：getDate()返回月份中的某一天，并getDay()返回星期几。给这些更具描述性的名字有多难？
        对于是否支持闰秒含糊其辞：“秒由 0 到 61 之间的整数表示；值 60 和 61 仅在闰秒时出现，即使如此，也仅在实际正确跟踪闰秒的 Java 实现中出现。” 我强烈怀疑大多数开发人员（包括我自己）都做了很多假设，认为 for 的范围getSeconds()实际上在 0-59 范围内（含）。
        它的宽容没有明显的理由：“在所有情况下，为这些目的而对方法给出的论据不必落在指定的范围内; 例如，日期可以指定为 1 月 32 日，并被解释为 2 月 1 日。” 多久有用一次？

        Date代表时间上的一个瞬间而不是一个日期。
        这意味着：它没有时区；它没有格式；它没有日历系统。
        */

        /*1. 耐心比对数据库日期字段和DO的映射

    （1）确定字段类型
        首先你需要确定数据对象中的 Date 字段代表的是日期、时间还是时间戳。

        如果字段代表日期和时间，则可能需要使用 LocalDateTime。
        如果字段仅代表日期，则可能需要使用 LocalDate。
        如果字段仅代表时间，则可能需要使用 LocalTime。
        如果字段需要保存时间戳（带时区的），则可能需要使用 Instant 或 ZonedDateTime。
    （2）更新数据对象类
        更新数据对象类中的字段，把 Date 类型改为适当的 java.time 类型。*/

        /*2. 将DateUtil中的方法改造
    （1）替换原来的new Date()和Calendar.getInstance().getTime()
        一些注意点:
        --Instant 表示的是一个时间点，它是时区无关的，相当于旧的 Date 类。它通常用于表示时间戳。
        --LocalDateTime 表示没有时区信息的日期和时间，它不能直接转换为时间戳，除非你将其与时区结合使用（例如通过 ZonedDateTime）。
        --ZonedDateTime 包含时区信息的日期和时间，它更类似于 Calendar，因为 Calendar 也包含时区信息。
当你需要将 java.time 对象转换回 java.util.Date 对象时，可以使用 Date.from(Instant) 方法。这在你的代码需要与旧的API或库交互时非常有用。

        */
        Date nowDate = new Date();
        Date nowCalendarDate = Calendar.getInstance().getTime();

        System.out.println("java.util.Date is "+ nowDate);
        System.out.println("java.utile.Calendar is "+ nowCalendarDate);
        // 使用Instant代表一个时间点，这与Date类似
        Instant nowInstant = Instant.now();
        System.out.println("java.time.instant is " + nowInstant);

        // 如果需要用到具体的日期和时间（例如年、月、日、时、分、秒）
        LocalDateTime nowLocalDateTime = LocalDateTime.now();
        System.out.println("java.time.LocalDateTime is " + nowLocalDateTime);


        // 如果你需要和特定的时区交互，可以使用ZonedDateTime
        ZonedDateTime nowZonedDateTime = ZonedDateTime.now();
        System.out.println("java.time.ZonedDateTime is " + nowZonedDateTime);

        // 如果你需要转换回java.util.Date，你可以这样做（假设你的代码其他部分还需要使用Date）
        Date nowFromDateInstant = Date.from(nowInstant);
        System.out.println("java.time.instant convert to Date is " + nowFromDateInstant);

        // 如果需要与java.sql.Timestamp交互
        java.sql.Timestamp nowFromInstant = java.sql.Timestamp.from(nowInstant);
        System.out.println("java.time.instant convert to java.sql.Timestamp is " + nowFromInstant);

        LocalDate nLocalDate = LocalDate.now();
        System.out.println("Today is " + dateToWeek(nLocalDate));

        System.out.println("today starttime to endtime is " + getStartTimeOfDay(nowLocalDateTime) + "----" + getEndTimeOfDay(nowLocalDateTime));

    }
}