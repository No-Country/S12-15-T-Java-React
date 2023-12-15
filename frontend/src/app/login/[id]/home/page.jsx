import { GuestProjects } from '@/components/Home/GuestProjects';
import { Projects } from '@/components/Home/Projects';
import { projects, guests } from '@/app/api/home/route';
import styleHome from '@/styles/home/home.module.css';
// import ResponsiveCarousel from '@/components/ResponsiveCarousel';
import { RecentActivity } from '@/components/RecentActivity';
// import Carousel from '@/components/Carousel';

const HomePage = () => {
	return (
		<div className="container">
			<main className={styleHome.homeShape}>
				<spam className={styleHome.homeHello}>👋!Hola de nuevo!</spam>
				{/* <Carousel/> */}
				<RecentActivity />
				{/* <ResponsiveCarousel/> */}
				<Projects dataProjects={projects} btnCreate={true} />
				<GuestProjects dataGuests={guests} btnCreate={false} />
			</main>
		</div>
	);
};

export default HomePage;
