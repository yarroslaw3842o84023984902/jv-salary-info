package core.basesyntax;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        int[] salary = new int[names.length];
        for (int i = 0; i < data.length; i++) {
            String[] resultArr;
            resultArr = data[i].split(" ");
            String[] dateResult = resultArr[0].split("\\.");
            String[] dateFromResult = dateFrom.split("\\.");
            String[] dateToResult = dateTo.split("\\.");
            int intDay = Integer.parseInt(dateResult[0]);
            int intMonth = Integer.parseInt(dateResult[1]);
            int year = Integer.parseInt(dateResult[2]);
            int fromIntDay = Integer.parseInt(dateFromResult[0]);
            int fromIntMonth = Integer.parseInt(dateFromResult[1]);
            int fromIntYear = Integer.parseInt(dateFromResult[2]);
            int toIntDay = Integer.parseInt(dateToResult[0]);
            int toIntMonth = Integer.parseInt(dateToResult[1]);
            int toIntYear = Integer.parseInt(dateToResult[2]);
            boolean isAfterOrEqualFrom =
                    (year > fromIntYear) ||
                            (year == fromIntYear && intMonth > fromIntMonth) ||
                            (year == fromIntYear && intMonth == fromIntMonth && intDay >= fromIntDay);

            boolean isBeforeOrEqualTo =
                    (year < toIntYear) ||
                            (year == toIntYear && intMonth < toIntMonth) ||
                            (year == toIntYear && intMonth == toIntMonth && intDay <= toIntDay);
            boolean isDateInRange = isAfterOrEqualFrom && isBeforeOrEqualTo;
            for (int k = 0; k < names.length; k++) {
                if (names[k].equals(resultArr[1]) && isDateInRange ) {
                    int hours = Integer.parseInt(resultArr[2]);
                    int betPerHours = Integer.parseInt(resultArr[3]);
                    int resultSalary = hours * betPerHours;
                    salary[k] += resultSalary;
                }
            }

        }
        StringBuilder report = new StringBuilder();
        report.append("Report for period ").append(dateFrom).append(" - ").append(dateTo);
        for (int k = 0; k < names.length; k++) {
            report.append("\n").append(names[k]).append(" - ").append(salary[k]);
        }
        return report.toString();
    }
}
