import { GuestProjects } from '@/components/home/GuestProjects';
import { Projects } from '@/components/home/Projects';
import { projects, guests } from '@/app/api/home/route';
import styleHome from '@/styles/home/home.module.css';

const HomePage = () => {
	return (
		<main className={styleHome.homeShape}>
			<spam className={styleHome.homeHello}>👋!Hola de nuevo!</spam>
			<Projects dataProjects={projects} />
			<GuestProjects dataGuests={guests} />
		</main>
	);
};

export default HomePage;
