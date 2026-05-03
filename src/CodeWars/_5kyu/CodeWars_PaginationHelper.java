package CodeWars._5kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeWars_PaginationHelper {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/515bb423de843ea99400000a/train/java

        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(">>> Numero pagine: " + helper.pageCount());
        System.out.println(">>> Numero Oggetti: " + helper.itemCount());
        System.out.println(">>> Numero Oggetti in questa pagina: " + helper.pageItemCount(0));
        System.out.println(">>> Numero Oggetti in questa pagina: " + helper.pageItemCount(1));
        System.out.println(">>> Numero Oggetti in questa pagina: " + helper.pageItemCount(2));
        System.out.println(">>> L'oggetto si trova in pagina: " + helper.pageIndex(5));
        System.out.println(">>> L'oggetto si trova in pagina: " + helper.pageIndex(2));
        System.out.println(">>> L'oggetto si trova in pagina: " + helper.pageIndex(20));
        System.out.println(">>> L'oggetto si trova in pagina: " + helper.pageIndex(-10));

    }
}

class PaginationHelper<I> {

    // The constructor takes in an array of items and an integer indicating how many items fit within a single page
    List<I> listaElementi = new ArrayList<>();
    int elementiPerPagina;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.listaElementi = collection;
        this.elementiPerPagina = itemsPerPage;
    }

    // returns the number of items within the entire collection
    public int itemCount() {
        return listaElementi.size();
    }

    // returns the number of pages
    public int pageCount() {
        if (itemCount() == 0 || elementiPerPagina <= 0) return 0;
        return (int) Math.ceil((double) itemCount() / elementiPerPagina);
    }

    // returns the number of items on the current page. page_index is zero based.
    // this method should return -1 for pageIndex values that are out of range
    public int pageItemCount(int pageIndex) {
        if(pageIndex < 0 || pageIndex >= pageCount()) return -1;
        if(pageIndex != pageCount() - 1) return elementiPerPagina;
        return itemCount() % elementiPerPagina == 0 ? elementiPerPagina : itemCount() % elementiPerPagina;

    }

    // determines what page an item is on. Zero based indexes
    // this method should return -1 for itemIndex values that are out of range
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex >= itemCount()) return -1;
        return itemIndex / elementiPerPagina;
    }
}