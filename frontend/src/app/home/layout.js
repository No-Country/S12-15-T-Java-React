import styleHome from '@/styles/home/home.module.css';
// import styleGlobals from '@/styles/globals.css';

export default function RootLayout({ children }) {
	return (
		<main className={styleHome.home}>
			<div className="container">{children}</div>
		</main>
	);
}
