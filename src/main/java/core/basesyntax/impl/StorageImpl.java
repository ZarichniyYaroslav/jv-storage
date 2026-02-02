package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private int sizeValue;
    private Object[] keyArray;
    private Object[] valueArray;

    public StorageImpl() {
        this.keyArray = new Object[10];
        this.sizeValue = 0;
        this.valueArray = new Object[10];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < sizeValue; i++) {
            if (Objects.equals(this.keyArray[i], key)) {
                this.keyArray[i] = key;
                this.valueArray[i] = value;
                return;
            }
        }
        this.keyArray[sizeValue] = key;
        this.valueArray[sizeValue] = value;
        sizeValue++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeValue; i++) {
            if (Objects.equals(this.keyArray[i], key)) {
                return (V) this.valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeValue;
    }
}
