import Link from 'next/link';
import '@/styles/navbar.css';
import DdProyects from './DdProyects';
import DdRecents from './DdRecents';

function Navbar() {
	return (
		<div className="nav-gral">
			<nav className="nav-container">
				<div className="track">
					<img src="/images/logo-logo.png" alt="Logo" />
					<h1 className="title">Track</h1>
				</div>
				<div className="dropdowns">
					<ul className="proyect-cont">
						<DdProyects />
						<DdRecents />
					</ul>
					<div className="btn-create">
						<Link href="/Crear" className="create">
							Create
						</Link>
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
