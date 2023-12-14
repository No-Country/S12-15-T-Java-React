import '@/styles/Landing/LandNav.css';

function LandNav() {
	return (
		<nav className="contenedorGral-Navlanding">
			<nav className="contenedor-logo-track">
				<div className="image-logo">
					<img src="/images/logo-logo.png" alt="Logo" />
				</div>

				<div className="ll-title">
					<h1 className="landing-logo-title">Track</h1>
				</div>
			</nav>
			<div className="contenedorBotonLogin">
				<button className="ll-btn">Login</button>
			</div>
		</nav>
	);
}

export default LandNav;
