package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        int[] salary = new int[names.length];
        LocalDate from = LocalDate.parse(dateFrom, FORMATTER);
        LocalDate to = LocalDate.parse(dateTo, FORMATTER);
        for (int i = 0; i < data.length; i++) {
            String[] resultArr = data[i].split(" ");
            LocalDate entryDate = LocalDate.parse(resultArr[0], FORMATTER);
            boolean isDateInRange = !entryDate.isBefore(from) && !entryDate.isAfter(to);
            if (isDateInRange) {
                for (int k = 0; k < names.length; k++) {
                    if (names[k].equals(resultArr[1])) {
                        int hours = Integer.parseInt(resultArr[2]);
                        int betPerHours = Integer.parseInt(resultArr[3]);
                        salary[k] += hours * betPerHours;
                    }
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
