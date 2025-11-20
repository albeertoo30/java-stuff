package topos.juego;

public record ContextoVisibilidad(
		Visibilidad centro, 
		Visibilidad arriba, 
		Visibilidad abajo, 
		Visibilidad izquierda, 
		Visibilidad derecha) {

}
