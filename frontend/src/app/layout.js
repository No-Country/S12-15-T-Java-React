import '@/styles/globals.css';
import '@/styles/navbar.css';

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
