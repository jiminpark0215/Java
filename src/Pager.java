import java.io.*;

//20240314 박지민 - 깜짝과제 3
public class Pager {

    private final long totalCount;
    private final long pageSize = 10;
    private long pageIndex;

    public Pager(long totalCount){
        this.totalCount = totalCount;
    }

    public String html(long pageIndex){
        StringBuilder sb = new StringBuilder();

        long totalPages = totalCount / pageSize;

        sb.append("<a href='#'>[처음]</a>\n");
        sb.append("<a href='#'>[이전]</a>\n");


        for (long i = 0; i < totalPages; i++) {
            if (i == pageIndex) {
                sb.append("<a href='#' class='on'>").append(i + 1).append("</a>\n");
            } else {
                sb.append("<a href='#'>").append(i + 1).append("</a>\n");
            }
        }

        sb.append("<a href='#'>[다음]</a>\n");
        sb.append("<a href='#'>[마지막]</a>\n");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        long totalCount = 127;
        long pageIndex = 12;

        Pager pager = new Pager(totalCount);
        System.out.println(pager.html(pageIndex));

    }
}