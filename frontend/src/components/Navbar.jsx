// components/Navbar.jsx
'use client';

import { useState } from 'react';
import Link from 'next/link';
import '@/styles/navbar.css';
import DdProyects from './DdProyects';
import DdRecents from './DdRecents';

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
					<label htmlFor="btn-menu">
						<img src="/images/Burguer.png" alt="" />
					</label>
				</div>
				<div className={`dropdowns ${menuVisible ? 'dd-complete' : ''}`}>
					<div className="dd-complete">
						<ul className="dd-cont">
							<li>
								<DdProyects />
							</li>
							<li>
								<DdRecents />
							</li>
						</ul>

						<div className="btn-create">
							<Link href="/Crear" className="create">
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
