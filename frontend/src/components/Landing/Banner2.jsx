import Link from 'next/link';

function Banner2() {
	return (
		<div className="Banner2-contenedorGral" id="Banner2-contenedorGral">
			<div className="banner2contenido">
				<h2 className="pregunta">¿Por que Elegir Track?</h2>
				<div className="card-contenedor">
					<div className="card">
						<img src="/images/Rapido.png" className="rapidoImg" />
						<h3 className="t-rapido">Rapido</h3>
						<p>
							Realiza Proyectos de manera rapida y eficiente con Track.
							Simplifica la gestion para un camino directo hacia el Exito.
						</p>
					</div>
					<div className="card">
						<img src="/images/Colaborativo.png" className="colaborativoImg" />
						<h3 className="t-colaborativo">Colaborativo</h3>
						<p>
							Crea vínculos fuertes y colabora sin esfuerzo con Track. Mejora la
							comunicación para lograr resultados extraordinarios.
						</p>
					</div>
					<div className="card">
						<img src="/images/Intuitivo.png" className="intuitivoImg" />
						<h3 className="t-intuitivo">Intuitivo</h3>
						<p>
							Descubre la potencia intuitiva de Track. Simplifica cada paso del
							proceso de gestión de proyectos.
						</p>
					</div>
				</div>

				<button type="submit" className="empiezaBtn">
					<Link href={'/register'}>Empieza ahora</Link>
				</button>
			</div>
		</div>
	);
}

export default Banner2;
