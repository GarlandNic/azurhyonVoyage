package com.azurhyon.azurhyonVoyage.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.azurhyon.azurhyonVoyage.dto.MeteoDto.Climats;
import com.azurhyon.azurhyonVoyage.dto.MeteoDto.Saisons;

public class TableMeteo {
    private final Map<Clé, EffetMeteo> table = new HashMap<>();

    public void ajouter(Climats clim, Saisons sais, int aujd, EffetMeteo effet) {
        table.put(new Clé(clim, sais, aujd), effet);
    }

    public EffetMeteo getEffet(Climats clim, Saisons sais, int aujd) {
        return table.getOrDefault(new Clé(clim, sais, aujd),
            new EffetMeteo(List.of("")));
    }

    private static class Clé {
        Climats clim;
        Saisons sais;
        int aujd;

        Clé(Climats clim, Saisons sais, int aujd) {
            this.clim = clim;
            this.sais = sais;
            this.aujd = aujd;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Clé)) return false;
            Clé clé = (Clé) o;
            return aujd == clé.aujd && clim == clé.clim && sais == clé.sais;
        }

        @Override
        public int hashCode() {
            return Objects.hash(clim, sais, aujd);
        }
    }
}
