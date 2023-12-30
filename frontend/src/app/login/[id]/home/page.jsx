'use client';
// import { GuestProjects } from '@/components/Home/GuestProjects';
import { Projects } from '@/components/Home/Projects';
import { getListSpace } from '@/app/api/home/route';
import styleHome from '@/styles/home/home.module.css';
import { useEffect, useState } from 'react';
// import ResponsiveCarousel from '@/components/ResponsiveCarousel';
import { RecentActivity } from '@/components/RecentActivity';
// import Carousel from '@/components/Carousel';
import withAuth from '@/lib/withAuth';

const HomePage = ({ params }) => {
	const { id } = params;
	const [spaces, setSpaces] = useState(null);

	useEffect(() => {
		const getAllListSpace = async () => {
			try {
				const allListSpace = await getListSpace(id);
				if (allListSpace != null) {
					setSpaces(allListSpace);
				} else {
					setSpaces(undefined);
				}
			} catch (error) {
				console.error('Error al obtener datos:', error);
			}
		};

		getAllListSpace();
	}, [id]);

	return (
		<div className="container">
			<main className={styleHome.homeShape}>
				<span className={styleHome.homeHello}>👋¡Hola de nuevo!</span>
				{/* <Carousel/> */}
				<RecentActivity />
				{/* <ResponsiveCarousel/> */}
				<Projects dataProjects={spaces} idUser={id} btnCreate={true} />
				{/* <GuestProjects dataGuests={guests} btnCreate={false} /> */}
			</main>
		</div>
	);
};

const ProtectHomePageAuth = withAuth(HomePage);

export default ProtectHomePageAuth;
