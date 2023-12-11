import styles from '@/styles/createworkspace.module.css';
import InputImg from '@/components/create/InputImg';
import BtnTrash from './BtnTrash';

const FormInputGroup = () => {
	return (
		<fieldset className={styles.container_form_group}>
			<div className={styles.container_input_content}>
				<label htmlFor="nameproyect">Nombre del proyecto:</label>
				<input
					type="text"
					id="nameproyect"
					name="nameproyect"
					placeholder="Nombre del proyecto"
				/>
			</div>
			<div className={styles.container_input_content}>
				<label htmlFor="description">Descripción:</label>
				<textarea
					placeholder="Descripción"
					id="description"
					name="description"
				></textarea>
			</div>
			<div className={styles.container_input_content}>
				<InputImg />
				<BtnTrash />
			</div>
		</fieldset>
	);
};

export default FormInputGroup;
