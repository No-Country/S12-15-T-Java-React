import '@/styles/globals.css';
import '@/styles/navbar.css';
import '@/styles/Landing/Banner.css';
import '@/styles/Landing/LandingNav.css';
import '@/styles/Landing/Banner2.css';

export const metadata = {
	title: 'Track',
	description:
		'Es una aplicación web y móvil que facilita la comunicación e implementación de metodologías ágiles para la gestión de cualquier proyecto. Tiene una interfaz dinámica e intuitiva los usuarios pueden saber qué tareas deben realizar.',
};

export default function RootLayout({ children }) {
	return (
		<html>
			<body>{children}</body>
		</html>
	);
}
