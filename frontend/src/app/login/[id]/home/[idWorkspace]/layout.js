import { Aside } from '@/components/Aside';
// import Sidebar from '@/components/workspace/Sidebar';

export default function RootLayout({ children, params }) {
	return (
		<main style={{ display: 'flex' }}>
			<Aside params={params} />
			{/* <Sidebar /> */}
			{children}
		</main>
	);
}
