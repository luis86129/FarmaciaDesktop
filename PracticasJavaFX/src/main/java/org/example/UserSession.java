package org.example;

public class UserSession {
    private static String usuarioLogueado;

    public static String getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static void setUsuarioLogueado(String usuario) {
        usuarioLogueado = usuario;
    }

    public static void cleanSession() {
        usuarioLogueado = null;
    }
}
