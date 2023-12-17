
//import { Slideshow } from '@/components/Slideshow';
import '@/styles/activity.css';
import styles from 'src/styles/activity.module.css';
import { Slideshow, Slide, TextoSlide } from '@/components/Slideshow';

function Carousel() {
	return (
		<main>
			<Slideshow>
				<div className={styles.containerall}>
					<div className={styles.marcoactivity}>
						<div className="nombre-proyecto">
							<h4 className={styles.letra}>Actividad reciente</h4>
						</div>
					</div>

					<div className={styles.containercards}>
						<div>
							<div className="nombre-proyecto">
								<img
									className="piccon"
									src="/images/Card-Recientes.png "
									alt="Texto alternativo de la imagen"
								/>
							</div>
						</div>
						<div>
							<div className="nombre-proyecto">
								<img
									className="piccon"
									src="/images/Card-Recientes2.png"
									alt="Texto alternativo de la imagen"
								/>
							</div>
						</div>
						<div>
							<div className="nombre-proyecto">
								<img
									className="piccon"
									src="/images/Card-Recientes3.png"
									alt="Texto alternativo de la imagen"
								/>{' '}
							</div>
						</div>
						<div>
							<div className="nombre-proyecto">
								<img
									className="piccon"
									src="/images/Card-Recientes4.png"
									alt="Texto alternativo de la imagen"
								/>
							</div>
						</div>
					</div>
				</div>
			</Slideshow>
		</main>
	);
}

export default Carousel;
