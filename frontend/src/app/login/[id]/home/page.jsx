'use client';
// import { GuestProjects } from '@/components/Home/GuestProjects';
import { Projects } from '@/components/Home/Projects';
import { getListSpace } from '@/app/api/home/route';
import styleHome from '@/styles/home/home.module.css';
import { useEffect, useState } from 'react';
// import Carousel from '@/components/Carousel';

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
				<spam className={styleHome.homeHello}>👋!Hola de nuevo!</spam>
				{/* <Carousel /> */}
				<Projects dataProjects={spaces} idUser={id} btnCreate={true} />
				{/* <GuestProjects dataGuests={guests} btnCreate={false} /> */}
			</main>
		</div>
	);
};

export default HomePage;
