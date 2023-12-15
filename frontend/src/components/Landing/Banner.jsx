function Banner() {
	return (
		<div className="banner-contenedorGral">
			<div className="banner-contenido">
				<div className="contenedor-h2-p-button">
					<h2 className="subtitulo">
						Domina tus Proyectos con Organizacion y Colaboración
					</h2>

					<p className="banner-txt">
						Gestiona proyectos de manera eficiente con Track, colabora con tu
						equipo, organiza Tareas y visualiza tu Progreso. Todo lo que
						necesitas para tu Proyecto en un solo lugar.
					</p>
					<div className="btncont">
						<button className="bescubre-btn" type="submit">
							Descubre Track
						</button>
					</div>
				</div>

				<div className="Contenedor-bannerImg">
					<img src="/images/ban.png" alt="Imagen" />
				</div>
			</div>
		</div>
	);
}

export default Banner;
