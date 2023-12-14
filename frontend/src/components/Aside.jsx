'use client';
import { useEffect } from 'react';
import '@/styles/activity.css';

export const Aside = () => {
	useEffect(() => {
		const btnToggle = document.querySelector('.toggle-btn');
		const sidebar = document.getElementById('sidebar');

		const handleClick = () => {
			console.log('clic');
			sidebar.classList.toggle('activos');
			console.log(document.getElementById('sidebar'));
		};

		if (btnToggle && sidebar) {
			btnToggle.addEventListener('click', handleClick);
		}

		// Limpia el evento al desmontar el componente
		return () => {
			if (btnToggle) {
				btnToggle.removeEventListener('click', handleClick);
			}
		};
	}, []);

	return (
		<aside id="sidebar">
			<div className="frame-766 toggle-btn">
				<div className=" vector2">
					<img src="/images/Vector2.png" alt="Texto alternativo de la imagen" />
				</div>
			</div>

			<div className="barra-lateral-tablero">
				<div className="frame-736">
					<div className="nombre-del-proyecto-en-el-caso-de-ser-mas-largo-se-acorta-ahi">
						Nombre del proyecto
					</div>
					<div className="icono-config" width="20" height="20">
						<div>
							<img
								src="/images/IconoConfig.png"
								alt="Texto alternativo de la imagen"
							/>
						</div>
					</div>
				</div>

				<div className="frame-737">
					<div className="frame-748">
						<div className="seccion-tablero">
							<div className="vector" width="16" height="17">
								<img
									src="/images/Vector.png"
									alt="Texto alternativo de la imagen"
								/>
							</div>
							<div className="canales-comunicaci-n">Canales comunicación </div>
						</div>
						<div className="frame-749">
							<div className="canales-tablero-agregar">
								<div className="icono-chat" width="16" height="16">
									<img
										src="/images/Icono_chat.png"
										alt="Texto alternativo de la imagen"
									/>
								</div>
								<div className="nombre">General </div>
							</div>
							<div className="canales-tablero-agregar2">
								<div className="icono-agregar" width="16" height="16">
									<img
										src="/images/Icono_Agregar.png"
										alt="Texto alternativo de la imagen"
									/>
								</div>
								<div className="nombre">Agregar Canal </div>
							</div>
						</div>
					</div>
				</div>
				<div className="frame-738">
					<div className="frame-7492">
						<div className="seccion-tablero">
							<div className="vector" width="16" height="17">
								<img
									src="/images/Vector.png"
									alt="Texto alternativo de la imagen"
								/>
							</div>
							<div className="canales-comunicaci-n">Tableros </div>
						</div>
						<div className="frame-749">
							<div className="canales-tablero-agregar">
								<div className="icono-tablero" width="16" height="15">
									<img
										src="/images/Icono_tablero.png"
										alt="Texto alternativo de la imagen"
									/>
								</div>
								<div className="nombre">General </div>
							</div>
							<div className="canales-tablero-agregar2">
								<div className="icono-agregar2" width="16" height="17">
									<img
										src="/images/Icono_Agregar.png"
										alt="Texto alternativo de la imagen"
									/>
								</div>
								<div className="nombre">Agregar Tablero </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</aside>
	);
};
