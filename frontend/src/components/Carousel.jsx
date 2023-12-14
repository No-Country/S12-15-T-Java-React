import { Slideshow, Slide, TextoSlide } from '@/components/Slideshow';

function Carousel() {
	return (
		<main>
			<Slideshow controles={true}>
				<Slide>
					<a href="#">
						<image
							src="/image/Card-Recientes.png"
							alt="Texto alternativo de la imagen"
						/>
					</a>
				</Slide>
				<Slide>
					<a href="#">
						<image
							src="/image/Card-Recientes2.png"
							alt="Texto alternativo de la imagen"
						/>
					</a>
					<TextoSlide></TextoSlide>
				</Slide>
				<Slide>
					<a href="#">
						<image
							src="/image/Card-Recientes3.png"
							alt="Texto alternativo de la imagen"
						/>
					</a>
					<TextoSlide></TextoSlide>
				</Slide>
				<Slide>
					<a href="#">
						<image
							src="/image/Card-Recientes4.png"
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
