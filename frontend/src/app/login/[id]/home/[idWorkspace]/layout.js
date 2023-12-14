import { Aside } from '@/components/Aside';
// import Sidebar from '@/components/workspace/Sidebar';

export default function RootLayout({ children }) {
	return (
		<main style={{ display: 'flex' }}>
			<Aside />
			{/* <Sidebar /> */}
			{children}
		</main>
	);
}
