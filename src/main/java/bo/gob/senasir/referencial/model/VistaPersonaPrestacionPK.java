/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.senasir.referencial.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pedrito
 */
@Embeddable
public class VistaPersonaPrestacionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "NupTitular", nullable = false)
    private long nupTitular;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NupDH", nullable = false)
    private long nupDH;

    public VistaPersonaPrestacionPK() {
    }

    public VistaPersonaPrestacionPK(long nupTitular, long nupDH) {
        this.nupTitular = nupTitular;
        this.nupDH = nupDH;
    }

    public long getNupTitular() {
        return nupTitular;
    }

    public void setNupTitular(long nupTitular) {
        this.nupTitular = nupTitular;
    }

    public long getNupDH() {
        return nupDH;
    }

    public void setNupDH(long nupDH) {
        this.nupDH = nupDH;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nupTitular;
        hash += (int) nupDH;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VistaPersonaPrestacionPK)) {
            return false;
        }
        VistaPersonaPrestacionPK other = (VistaPersonaPrestacionPK) object;
        if (this.nupTitular != other.nupTitular) {
            return false;
        }
        if (this.nupDH != other.nupDH) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.gob.senasir.referencial.model.VistaPersonaPrestacionPK[ nupTitular=" + nupTitular + ", nupDH=" + nupDH + " ]";
    }
    
}
