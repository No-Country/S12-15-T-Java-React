import Link from 'next/link';
import '@/styles/Landing/Banner.css';
function Banner() {
	return (
		<div className="banner-contenedorGral">
			<div className="banner-contenido">
				<div className="contenedor-h2-p-button">
					<h2 className="subtitulo">
						Domina tus Proyectos con Organización y Colaboración
					</h2>

					<p className="banner-txt">
						Gestiona proyectos de manera eficiente con Track, colabora con tu
						equipo, organiza tareas y visualiza tu progreso. Todo lo que
						necesitas para tu proyecto en un solo lugar.
					</p>
					<div className="btn-cont">
						<Link href="/register">
							<button className="descubre-btn">Descubre Track</button>
						</Link>
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
