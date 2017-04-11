package template;

/**
 * Created by shj on 2017/4/11.
 */
public class Pagination {
    private int totalItems;
    private int currentPage;

    public Pagination(int totalItems, int currentPage) {
        this.totalItems = totalItems;
        this.currentPage = currentPage;
    }

    public Pagination() {
    }

    @Override
    public String toString() {
        return "pagination{" +
                "totalItems=" + totalItems +
                ", currentPage=" + currentPage +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pagination that = (Pagination) o;

        if (totalItems != that.totalItems) return false;
        return currentPage == that.currentPage;
    }

    @Override
    public int hashCode() {
        int result = totalItems;
        result = 31 * result + currentPage;
        return result;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
