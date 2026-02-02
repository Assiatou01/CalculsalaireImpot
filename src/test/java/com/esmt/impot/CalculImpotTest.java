package com.esmt.impot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.time.Instant;

class CalculImpotTest {

    static Instant startAll;

    @BeforeAll
    static void startTimer() {
        startAll = Instant.now();
        System.out.println("Début des tests...");
    }

    @AfterAll
    static void endTimer() {
        Instant endAll = Instant.now();
        long duration = Duration.between(startAll, endAll).toMillis();
        System.out.println("Durée totale des tests : " + duration + " ms");
    }

    @BeforeEach
    void setUp(TestInfo info) {
        System.out.println("Début test : " + info.getDisplayName());
    }

    @AfterEach
    void tearDown(TestInfo info) {
        System.out.println("Fin test : " + info.getDisplayName());
        System.out.println("--------------------------------");
    }

    // ------------------ TESTS PARTS ------------------
//
//    @ParameterizedTest
//    @CsvSource({
//            "false,0,1.5",
//            "false,3,3.0",
//            "true,3,3.5",
//            "true,8,5.0"
//    })
//    void testCalculParts(boolean marie, int enfants, double attendu) {
//        double resultat = CalculImpot.calculerParts(marie, enfants);
//        assertEquals(attendu, resultat);
//    }
//
//    // ------------------ TESTS ABATTEMENT ------------------
//
//    @ParameterizedTest
//    @CsvSource({
//            "100000,30000",
//            "500000,150000",
//            "2000000,300000"
//    })
//    void testCalculAbattement(double brut, double attendu) {
//        double resultat = CalculImpot.calculerAbattement(brut);
//        assertEquals(attendu, resultat);
//    }
//
//    // ------------------ TESTS SALAIRE NET ------------------
//
//    @ParameterizedTest(name = "Salaire brut: {0}, Marié: {1}, Enfants: {2} => Salaire net attendu: {3}")
//    @CsvFileSource(resources = "/donnees_test.csv")
//    void testCalculSalaireNet(double salaireBrut, boolean marie, int enfants, double salaireNetAttendu) {
//        double salaireNetCalcule = CalculImpot.calculerSalaireNet(salaireBrut, marie, enfants);
//        assertEquals(salaireNetAttendu, salaireNetCalcule, 1,
//                "Salaire net calculé pour " + salaireBrut +
//                        " (marié: " + marie + ", enfants: " + enfants + ")");
//    }
//
//    // ------------------ TESTS ERREURS ------------------

    @Test
    void testSalaireInferieurAuMinimum() {
        assertThrows(IllegalArgumentException.class, () ->
                CalculImpot.calculerSalaireNet(59999, false, 0));
    }

    @Test
    void testSalaireSuperieurAuMaximum() {
        assertThrows(IllegalArgumentException.class, () ->
                CalculImpot.calculerSalaireNet(3000001, true, 2));
    }
}