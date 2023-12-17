import '@/styles/globals.css';
import '@/styles/navbar.css';
import '@/styles/Landing/Banner.css';
import '@/styles/Landing/LandNav.css';
import '@/styles/Landing/Banner2.css';

export const metadata = {
	title: 'Next',
	description: 'Generated Next',
};

export default function RootLayout({ children }) {
	return (
		<html>
			<body>{children}</body>
		</html>
	);
}
