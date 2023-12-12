'use client';
import React from 'react';

import { Aside } from './components/Home/Aside';

//import { Aside2 } from './components/Home/Aside2';
//import { RecentActivity } from './components/Home/RecentActivity';
//import { Slideshow } from './components/Home/Slideshow';

//import React from 'react';

import '../styles/estilos.css';
import styled from 'styled-components';


import {Slideshow, Slide, TextoSlide}  from '@/app/components/Home/Slideshow';

const Home = () => {
	return (

<main>
	
			<Slideshow   controles={true}>
				<Slide>
					<a href="#">
					<img  src="/img/Card-Recientes.png" alt="Texto alternativo de la imagen"/>
					</a>
					
				</Slide>
				<Slide>
				<a href="#">
					<img  src="/img/Card-Recientes2.png" alt="Texto alternativo de la imagen"/>
					</a>
					<TextoSlide>
						
					</TextoSlide>
				</Slide>
				<Slide>
				<a href="#">
					<img  src="/img/Card-Recientes3.png" alt="Texto alternativo de la imagen"/>
					</a>
					<TextoSlide>
						
					</TextoSlide>
				</Slide>
				<Slide>
				<a href="#">
					<img  src="/img/Card-Recientes4.png" alt="Texto alternativo de la imagen"/>
					</a>
					<TextoSlide>
						
					</TextoSlide>
				</Slide>
			
				</Slideshow>
			

			<div>
			<h1>hi there</h1>
			
			{/* <RecentActivity /> */}
			{/* <Aside2/> */}
			<Aside />
		</div>
	
		</main>

		
);};



export default Home;
