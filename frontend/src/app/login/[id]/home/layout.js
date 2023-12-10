import styleHome from '@/styles/home/home.module.css';

export default function RootLayout({ children }) {
	return <main className={styleHome.home}>{children}</main>;
}
