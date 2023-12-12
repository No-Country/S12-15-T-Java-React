import { GuestProjects } from '@/components/home/GuestProjects';
import { Projects } from '@/components/home/Projects';
import { projects, guests } from '@/app/api/home/route';
import styleHome from '@/styles/home/home.module.css';

const HomePage = () => {
	return (
		<div className="container">
			<main className={styleHome.homeShape}>
				<spam className={styleHome.homeHello}>👋!Hola de nuevo!</spam>
				<Projects dataProjects={projects} btnCreate={true} />
				<GuestProjects dataGuests={guests} btnCreate={false} />
			</main>
		</div>
	);
};

export default HomePage;