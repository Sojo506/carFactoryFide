package util;

import java.awt.Color;

public class Colors {

    // Fondo general tipo fábrica
    public static final Color METAL_GRAY = new Color(0x2F2F2F);       // Gris oscuro industrial (estructura base)
    public static final Color DARK_GRAY = new Color(0x4F4F4F);        // Gris medio (cinta transportadora)
    public static final Color DIRTY_GRAY = new Color(0x555555);       // Gris sucio (basurero inactivo)
    public static final Color LIGHT_GRAY = new Color(0xE0E0E0);       // Gris claro (textos, íconos claros)

    // Paneles específicos
    public static final Color HUD_PANEL = new Color(0x1C2833);         // Azul acero oscuro (HUDPanel, headers)
    public static final Color ASSEMBLY_PANEL = new Color(0x3B3B3B);   // Línea de ensamblaje (gris uniforme opaco)
    public static final Color BELT_ACTIVE = new Color(0x6E6E6E);      // Fondo activo de la cinta
    public static final Color TRASH_ACTIVE = new Color(0xB00020);     // Basurero activo (rojo oscuro intenso)
    public static final Color ASSEMBLY_LINE_SLOT = new Color(0x5A5A5A); // Gris medio con contraste


    // Tonos de estado
    public static final Color WARNING_YELLOW = new Color(0xF2C94C);   // Amarillo de advertencia
    public static final Color SUCCESS_GREEN = new Color(0x6FCF97);    // Verde de éxito (carro correcto)
    public static final Color ERROR_RED = new Color(0xEB5757);        // Rojo de error (descartado o incorrecto)

    // Texto y bordes
    public static final Color PURE_BLACK = new Color(0x000000);       // Negro absoluto
    public static final Color PURE_WHITE = new Color(0xFFFFFF);       // Blanco puro
}
