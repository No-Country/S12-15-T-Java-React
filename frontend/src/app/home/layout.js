import styleHome from '@/styles/home.module.css';

export default function RootLayout({ children }) {
	return (
		<main>
			<div className={styleHome.home}>{children}</div>
		</main>
	);
}
