'use client';
import { useState } from 'react';
import '@/styles/navbar.css';
import '@/styles/Burguer.css';
// import DdProyects from './DdProyects';
import Burguer from './Burguer';
import Link from 'next/link';

function Navbar() {
	let user;
	if (typeof window !== 'undefined')
		user = JSON.parse(localStorage.getItem('user'));
	const [menuVisible, setMenuVisible] = useState(false);

	const toggleMenu = () => {
		setMenuVisible(!menuVisible);
	};

	const logOut = () => {
		localStorage.clear();
		window.location.href = '/';
	};

	return (
		<div className="nav-gral">
			<nav className="nav-container">
				<div className="container-menu-left">
					<div className="track">
						<img src="/images/logo-logo.png" alt="Logo" />
						<Link href={`/login/${user?.id}/home/`} className="white-link">
							<h1 className="title">Track</h1>
						</Link>
					</div>

					<div className="btn-menu">
						<input
							type="checkbox"
							id="btn-menu"
							checked={menuVisible}
							onChange={toggleMenu}
						/>

						<div className="brg">
							{/* contiene el burguer Button */}
							<Burguer />
						</div>
					</div>

					<div className={`dropdowns ${menuVisible ? 'dd-complete' : ''}`}>
						<div className="dd-complete">
							{/* contiene los botones proyect, recent, create */}
							<ul className="dd-cont">
								<li className="option-projet">
									{/* <DdProyects /> */}
									<div className="btn-create" id={'pr'}>
										<Link href={`/login/${user?.id}/home/`} className="create">
											Proyectos Recientes
										</Link>
										<div className="submenu">
											<Link
												href={
													'https://track-flob.onrender.com/v1/api/space/listOfSpaces'
												}
												className="links"
											>
												<h3>Proyecto A</h3>
											</Link>
											<Link
												href={
													'https://track-flob.onrender.com/v1/api/space/listOfSpaces'
												}
												className="links"
											>
												<h3>Proyecto B</h3>
											</Link>
											<Link
												href={
													'https://track-flob.onrender.com/v1/api/space/listOfSpaces'
												}
												className="links"
											>
												<h3>Proyecto C</h3>
											</Link>
										</div>
									</div>
								</li>
							</ul>
							<div className="btn-create">
								{/* contiene el boton create */}
								<Link
									href={`/login/${user?.id}/create-workspace`}
									className="create"
								>
									Crear
								</Link>
							</div>
						</div>
						<div className="container-menu-right">
							<img
								src="/images/Usuario.png"
								alt="Imagen de USUARIO"
								className="logo-user"
							/>
							<button className="btn-logout" onClick={() => logOut()}>
								Cerrar sesión
							</button>
						</div>
					</div>
				</div>
			</nav>
		</div>
	);
}

export default Navbar;
