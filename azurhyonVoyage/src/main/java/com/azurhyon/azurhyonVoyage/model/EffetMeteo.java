package com.azurhyon.azurhyonVoyage.model;

import java.util.List;

public class EffetMeteo {
    private final List<String> effets;

    public EffetMeteo(List<String> effets) {
        this.effets = effets;
    }

    public List<String> getEffets() { return effets; }

    @Override
    public String toString() {
        return String.join(", ", effets);
    }
}
