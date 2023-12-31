import Navbar from '@/components/Navbar';
import '@/styles/navbar.css';
import '@/styles/Dropdown.css';
import '@/styles/Flecha.css';
import '@/styles/Burguer.css';

export default function RootLayout({ children }) {
	return (
		<main>
			<Navbar />
			{children}
		</main>
	);
}
