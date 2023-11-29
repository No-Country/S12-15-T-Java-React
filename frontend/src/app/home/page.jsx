import { GuestProjects } from '@/components/Home/GuestProjects';
import { Projects } from '@/components/Home/Projects';
import styleHome from '@/styles/home.module.css';

const HomePage = () => {
	return (
		<main className={styleHome.homeShape}>
			<spam>!Hola de nuevo!</spam>
			<Projects />
			<GuestProjects />
		</main>
	);
};

export default HomePage;
