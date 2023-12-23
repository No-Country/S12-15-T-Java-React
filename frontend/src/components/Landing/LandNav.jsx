import '@/styles/Landing/LandingNav.css';
import Link from 'next/link';
function LandNav() {
	return (
		<nav className="contenedorGral-Navlanding">
			<div className="contenedor-navbar">
				<nav className="contenedor-logo-track">
					<div className="image-logo">
						<img src="/images/logo-logo.png" alt="Logo" />
					</div>

				<div className="ll-title">
					<h1 className="landing-logo-title">Track</h1>
				</div>
			</nav>
			<div className="contenedorBotonLogin">
				<div className="ll-btn">
					<Link href={'/login'}>Login</Link>
				</div>
			</div>
		</nav>
	);
}

export default LandNav;
