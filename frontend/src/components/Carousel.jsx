import { Slideshow, Slide, TextoSlide } from '@/app/components/Slideshow';

function Carousel() {
	return (
		<main>
			<Slideshow controles={true}>
				<Slide>
					<a href="#">
						<img
							src="/img/Card-Recientes.png"
							alt="Texto alternativo de la imagen"
						/>
					</a>
				</Slide>
				<Slide>
					<a href="#">
						<img
							src="/img/Card-Recientes2.png"
							alt="Texto alternativo de la imagen"
						/>
					</a>
					<TextoSlide></TextoSlide>
				</Slide>
				<Slide>
					<a href="#">
						<img
							src="/img/Card-Recientes3.png"
							alt="Texto alternativo de la imagen"
						/>
					</a>
					<TextoSlide></TextoSlide>
				</Slide>
				<Slide>
					<a href="#">
						<img
							src="/img/Card-Recientes4.png"
							alt="Texto alternativo de la imagen"
						/>
					</a>
					<TextoSlide></TextoSlide>
				</Slide>
			</Slideshow>

			<div></div>
		</main>
	);
}

export default Carousel;
