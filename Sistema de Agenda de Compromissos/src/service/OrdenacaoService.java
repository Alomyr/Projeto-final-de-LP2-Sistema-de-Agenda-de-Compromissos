package service;

import java.util.Comparator;
import java.util.List;

import util.Ordenacao;

public class OrdenacaoService<T> implements Ordenacao<T> {

    private void heapify(List<T> lista, int n, int i, Comparator<T> comparator) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && comparator.compare(lista.get(left), lista.get(largest)) > 0) {
            largest = left;
        }

        if (right < n && comparator.compare(lista.get(right), lista.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = lista.get(i);
            lista.set(i, lista.get(largest));
            lista.set(largest, temp);
            heapify(lista, n, largest, comparator);
        }
    }

    @Override
    public void ordenar(List<T> lista, Comparator<T> comparator) {
        if (lista == null || comparator == null) {
            return;
        }

        int n = lista.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(lista, n, i, comparator);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = lista.get(0);
            lista.set(0, lista.get(i));
            lista.set(i, temp);

            heapify(lista, i, 0, comparator);
        }
    }
    
}
