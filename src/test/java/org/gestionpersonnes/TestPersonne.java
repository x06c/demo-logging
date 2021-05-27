package org.gestionpersonnes;

import static org.junit.Assert.*;
import learn.junit.Personne;
import org.junit.Before;
import org.junit.Test;


public class TestPersonne {

    private Personne p;
    private String nom = "DORT";
    private String prenom = "Objik";
    private String adresse = "Marble Street";
    private String ville = "Manchester";
    private String codePostal = "01234";
    private String cpShort = "234";
    private String cpAlphaNum = "AG234";



    @Before
    public void setUp() {
        p = new Personne(nom, prenom, adresse, ville, codePostal);
    }

    /**
     * Premier test : instanceof Personne NotNull
     */
    @Test
    public void testPersonne() {
        assertNotNull(p);
    }

    /**
     * Test Getter NotNull -> getNom
     */
    @Test
    public void testGetterNotNull() {
        assertNotNull(p.getNom());
        assertNotNull(p.getPrenom());
        assertNotNull(p.getAdresse());
        assertNotNull(p.getVille());
        assertNotNull(p.getCodepostal());
    }

    /**
     * Test toString
     */
    @Test
    public void testToString() {
        String expected = p.getClass().getSimpleName() + " [nom=" + p.getNom() + ", prenom=" + p.getPrenom() + ", adresse=" + p.getAdresse() + ", ville=" + p.getVille() + ", codepostal=" + p.getCodepostal() + "]";
        assertEquals(expected, p.toString());
    }

    /**
     * Test sur fonction CtrlCodePostal
     */
    @Test
    public void testCtrlCodePostal() {
        try {
            Personne.CtrlCodePostal(codePostal);
            assertTrue(true);
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Test sur fonction CtrlCodePostal si cp ne contient pas 5 valeurs numériques
     * Exception
     */
    @Test (expected = Exception.class)
    public void testCtrlCodePostal5Nbr() throws Exception {
        Personne.CtrlCodePostal(cpShort);
    }

    /**
     * Test sur fonction CtrlCodePostal avec cp contenant des valeurs alpha numerique
     */
    @Test (expected = Exception.class)
    public void testCtrlCodePostalAlphaNum() throws Exception {
        Personne.CtrlCodePostal(cpAlphaNum);
    }

    /**
     * Test du Setter à value Null
     */
    @Test
    public void testSetterNull() {
        p.setNom(null);
        p.setVille(null);
        assertNull(p.getNom());
        assertNull(p.getVille());
    }






}
