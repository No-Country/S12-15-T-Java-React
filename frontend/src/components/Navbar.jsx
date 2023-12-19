// components/Navbar.jsx
'use client';

import { useState } from 'react';
import Link from 'next/link';
import '@/styles/navbar.css';
import '@/styles/Burguer.css';
import DdProyects from './DdProyects';
import Burguer from './Burguer';

function Navbar() {
	const [menuVisible, setMenuVisible] = useState(false);

	const toggleMenu = () => {
		setMenuVisible(!menuVisible);
	};

	return (
		<div className="nav-gral">
			<nav className="nav-container">
				<div className="track">
					<img src="/images/logo-logo.png" alt="Logo" />
					<h1 className="title">Track</h1>
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
								<DdProyects />
							</li>
						</ul>
						<div className="btn-create">
							{/* contiene el boton create */}
							<Link href="/crear" className="create">
								Create
							</Link>
						</div>
					</div>
				</div>

				<div className="logo-user">
					<img src="/images/Usuario.png" alt="Imagen de USUARIO" />
				</div>
			</nav>
		</div>
	);
}

export default Navbar;
