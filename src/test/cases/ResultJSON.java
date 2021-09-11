package test.cases;

import java.util.List;

public class ResultJSON {
    private int page;
    private int per_page;
    private int total;
    private int toal_pages;
    private List<ResultData> resultDataList;

    public ResultJSON() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getToal_pages() {
        return toal_pages;
    }

    public void setToal_pages(int toal_pages) {
        this.toal_pages = toal_pages;
    }

    public List<ResultData> getResultDataList() {
        return resultDataList;
    }

    public void setResultDataList(List<ResultData> resultDataList) {
        this.resultDataList = resultDataList;
    }
}
