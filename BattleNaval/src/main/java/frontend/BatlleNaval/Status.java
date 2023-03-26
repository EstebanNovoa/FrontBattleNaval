/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package frontend.BatlleNaval;

/**
 * @author novoa
 */
public enum Status {
    CBS('.'), // Casilla blanca sin destruir
    CB('-'), // Casilla con barco
    CBD('x'), // Casilla con barco destruido
    CD(','); // Casilla descubierta (sin valor)

    private final char value;

    private Status(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }
}
