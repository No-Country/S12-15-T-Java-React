/* 'use client';
import { useRef, useEffect, useCallback, useState } from 'react';
import styled from 'styled-components';
import '@/styles/estilos.css';

const Slideshow = ({
	children,
	controles = false,
	autoplay = false,
	velocidad = '1000',
	intervalo = '3000',
}) => {
	const slideshow = useRef(null);
	const intervaloSlideshow = useRef(null);
	const [windowWidth, setWindowWidth] = useState(0);

	useEffect(() => {
		const handleResize = () => {
			setWindowWidth(window.innerWidth);
		};

		window.addEventListener('resize', handleResize);

		return () => {
			window.removeEventListener('resize', handleResize);
		};
	}, []);

	const siguiente = useCallback(() => {
		if (slideshow.current && slideshow.current.children.length > 0) {
			const primerElemento = slideshow.current.children[0];

			slideshow.current.style.transition = `${velocidad}ms ease-out all`;

			const tamañoSlide = slideshow.current.children[0].offsetWidth;

			slideshow.current.style.transform = `translateX(-${tamañoSlide}px)`;

			const transicion = () => {
				slideshow.current.style.transition = 'none';
				slideshow.current.style.transform = 'translateX(0)';

				if (primerElemento) {
					slideshow.current.appendChild(primerElemento);
				}

				slideshow.current.removeEventListener('transitionend', transicion);
			};

			slideshow.current.addEventListener('transitionend', transicion);
		}
	}, [velocidad]);

	const anterior = () => {
		if (slideshow.current && slideshow.current.children.length > 0) {
			const index = slideshow.current.children.length - 1;
			const ultimoElemento = slideshow.current.children[index];
			slideshow.current.insertBefore(
				ultimoElemento,
				slideshow.current.firstChild
			);

			slideshow.current.style.transition = 'none';
			const tamañoSlide = slideshow.current.children[0].offsetWidth;
			slideshow.current.style.transform = `translateX(-${tamañoSlide}px)`;

			setTimeout(() => {
				slideshow.current.style.transition = `${velocidad}ms ease-out all`;
				slideshow.current.style.transform = 'translateX(0)';
			}, 30);
		}
	};

	useEffect(() => {
		if (autoplay && windowWidth <= 700) {
			intervaloSlideshow.current = setInterval(() => {
				siguiente();
			}, intervalo);

			if (slideshow.current) {
				slideshow.current.addEventListener('mouseenter', () => {
					clearInterval(intervaloSlideshow.current);
				});

				slideshow.current.addEventListener('mouseleave', () => {
					intervaloSlideshow.current = setInterval(() => {
						siguiente();
					}, intervalo);
				});
			}
		}
	}, [autoplay, intervalo, siguiente, windowWidth]);

	if (windowWidth >= 700) {
		return null;
	}

	return (
		<div>
			<div className="head-4">
				<Actir>Actividad reciente </Actir>
			</div>

			<ContenedorPrincipal>
				<ContenedorSlideshow ref={slideshow}>{children}</ContenedorSlideshow>
				{controles && (
					<Controles>
						<Boton onClick={anterior}>
							<img
								onClick={anterior}
								src="/images/flechai.png"
								alt="Texto alternativo de la imagen"
							/>
						</Boton>
						<Boton type="submit" derecho onClick={siguiente}>
							<img
								onClick={siguiente}
								src="/images/flechad.png"
								alt="Texto alternativo de la imagen"
							/>
						</Boton>
					</Controles>
				)}
			</ContenedorPrincipal>
		</div>
	);
};

const Actir = styled.div`
	color: black;
`;

const ContenedorPrincipal = styled.div`
	position: relative;
	border-radius: 0px 0px 58px 58px;
	width: 276px;
	height: 43px;
`;

const ContenedorSlideshow = styled.div`
	border-radius: 0px 0px 58px 58px;
	width: 276px;
	height: auto;
	display: flex;
	flex-wrap: nowrap;
`;

const Slide = styled.div`
	background: white;
	width:auto;
	overflow: hidden;
	transition: 0.3s ease all;
	z-index: 10;
	position: relative;

	img {
		width: 180px;
	height: 100;
	  }
`;

const TextoSlide = styled.div`
	background: ${(props) =>
		props.colorFondo ? props.colorFondo : 'rgba(0,0,0,.3)'};
	color: ${(props) => (props.colorTexto ? props.colorTexto : '#fff')};
	width: 100%;
	padding: 10px 60px;
	text-align: center;
	position: absolute;
	bottom: 0;

	@media screen and (max-width: 700px) {
		position: relative;
		background: white;
	}
`;

const Controles = styled.div`
	position: absolute;
	top: 0;
	z-index: 20;
	width: 100%;
	height: 100%;
	pointer-events: none;
`;

const Boton = styled.button`
	pointer-events: all;
	background: white;
	border-radius: px 0px 0px 58px;

	border: none;
	cursor: pointer;
	outline: none;
	width: 50px;
	height: 100%;
	text-align: center;
	position: absolute;
	transition: 0.3s ease all;

	img {
		width: 100%;
		height: 30%;
	}

	path {
		filter: ${(props) =>
			props.derecho
				? 'drop-shadow(-2px 0px 0px #fff)'
				: 'drop-shadow(2px 0px 0px #fff)'};
	}

	${(props) => (props.derecho ? 'right: 0' : 'left: 0')}
`;

export { Slideshow, Slide, TextoSlide };
 */

/* import { useRef, useEffect, useCallback, useState } from 'react';
import styled from 'styled-components';
import '@/styles/estilos.css'; */
'use client';
import { useRef, useEffect, useCallback, useState } from 'react';
import styled from 'styled-components';
import '@/styles/estilos.css';

const Slideshow = ({
	children,
	controles = false,
	autoplay = false,
	velocidad = '1000',
	intervalo = '3000',
}) => {
	const slideshow = useRef(null);
	const intervaloSlideshow = useRef(null);
	const [windowWidth, setWindowWidth] = useState(0);

	useEffect(() => {
		const handleResize = () => {
			setWindowWidth(window.innerWidth);
		};

		window.addEventListener('resize', handleResize);

		return () => {
			window.removeEventListener('resize', handleResize);
		};
	}, []);

	const siguiente = useCallback(() => {
		if (slideshow.current && slideshow.current.children.length > 0) {
			const primerElemento = slideshow.current.children[0];

			slideshow.current.style.transition = `${velocidad}ms ease-out all`;

			const tamañoSlide = slideshow.current.children[0].offsetWidth;

			slideshow.current.style.transform = `translateX(-${tamañoSlide}px)`;

			const transicion = () => {
				slideshow.current.style.transition = 'none';
				slideshow.current.style.transform = 'translateX(0)';

				if (primerElemento) {
					slideshow.current.appendChild(primerElemento);
				}

				slideshow.current.removeEventListener('transitionend', transicion);
			};

			slideshow.current.addEventListener('transitionend', transicion);
		}
	}, [velocidad]);

	const anterior = () => {
		if (slideshow.current && slideshow.current.children.length > 0) {
			const index = slideshow.current.children.length - 1;
			const ultimoElemento = slideshow.current.children[index];
			slideshow.current.insertBefore(
				ultimoElemento,
				slideshow.current.firstChild
			);

			slideshow.current.style.transition = 'none';
			const tamañoSlide = slideshow.current.children[0].offsetWidth;
			slideshow.current.style.transform = `translateX(-${tamañoSlide}px)`;

			setTimeout(() => {
				slideshow.current.style.transition = `${velocidad}ms ease-out all`;
				slideshow.current.style.transform = 'translateX(0)';
			}, 30);
		}
	};

	useEffect(() => {
		if (autoplay && windowWidth <= 700) {
			intervaloSlideshow.current = setInterval(() => {
				siguiente();
			}, intervalo);

			if (slideshow.current) {
				slideshow.current.addEventListener('mouseenter', () => {
					clearInterval(intervaloSlideshow.current);
				});

				slideshow.current.addEventListener('mouseleave', () => {
					intervaloSlideshow.current = setInterval(() => {
						siguiente();
					}, intervalo);
				});
			}
		}
	}, [autoplay, intervalo, siguiente, windowWidth]);

	if (windowWidth >= 700) {
		return null;
	}

	return (
		<div>
			{/* <div className="head-4" >
        <Actir >
    Actividad reciente </Actir>
    </div> */}

			<ContenedorPrincipal>
				<ContenedorSlideshow ref={slideshow}>{children}</ContenedorSlideshow>
				{controles && (
					<Controles>
						<Boton onClick={anterior}>
							<img
								onClick={anterior}
								src="/images/flechai.png"
								alt="Texto alternativo de la imagen"
							/>
						</Boton>
						<Boton type="submit" derecho onClick={siguiente}>
							<img
								onClick={siguiente}
								src="/images/flechad.png"
								alt="Texto alternativo de la imagen"
							/>
						</Boton>
					</Controles>
				)}
			</ContenedorPrincipal>
		</div>
	);
};

/* const Actir=styled.div `
color:black;
`; */

const ContenedorPrincipal = styled.div`
	/*  position: relative;
  border-radius: 0px 0px 58px 58px;
  width: 900px;
	height:auto;
	display: flex;
  
	flex-direction: row;
  
	align-items: center;
  
	justify-content: space-between;
	margin: auto;
	flex-wrap: wrap;
	align-self: stretch; */
`;

const ContenedorSlideshow = styled.div`
border-radius: 0px 0px 58px 58px;
/* width: 900px;
height: auto;
  /* display: flex;
  
  flex-direction: row;

  align-items: center;

  justify-content: space-between;
  margin: auto;
  flex-wrap: wrap;
  padding: 16px 24px 16px 24px;
	max-width: 944px;
	height: auto;
	/* box-shadow: 0px 4px 4px 4px rgba(0, 0, 0, 0.50); */
	box-shadow: 0px 0px 1px 1px rgba(0, 0, 0, 0.50);

	border-style: solid;
	border-color: rgba(0, 0, 0, 0.50);
	gap:10px
  align-self: stretch; */ */
`;

const Slide = styled.div`
	background: white;
	/*   width: 900px;
height: auto;
  overflow: hidden;
  transition: 0.3s ease all;
  z-index: 10;
  position: relative; */

	img {
		width: 20%;
		height: 180px;
		// background-size: cover
		// vertical-align: top;
	}
`;
/* 
const TextoSlide = styled.div`
  background: ${props => props.colorFondo ? props.colorFondo : 'rgba(0,0,0,.3)'};
  color: ${props => props.colorTexto ? props.colorTexto : '#fff'};
  width: 100%;
  padding: 10px 60px;
  text-align: center;
  position: absolute;
  bottom: 0;

  @media screen and (max-width: 700px) {
    position: relative;
    background: white;
  }
`; */

const Controles = styled.div`
	position: absolute;
	top: 0;
	z-index: 20;
	width: 100%;
	height: 100%;
	pointer-events: none;
`;

const Boton = styled.button`
	pointer-events: all;
	background: white;
	border-radius: px 0px 0px 58px;

	border: none;
	cursor: pointer;
	outline: none;
	width: 50px;
	height: 100%;
	text-align: center;
	position: absolute;
	transition: 0.3s ease all;

	img {
		width: 89%;
		height: 30%;
	}

	path {
		filter: ${(props) =>
			props.derecho
				? 'drop-shadow(-2px 0px 0px #fff)'
				: 'drop-shadow(2px 0px 0px #fff)'};
	}

	${(props) => (props.derecho ? 'right: 0' : 'left: 0')}
`;

export { Slideshow, Slide };
